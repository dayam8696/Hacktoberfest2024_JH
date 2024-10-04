import express from "express"
import http from "http"
import { Server } from "socket.io";

const PORT = 3000;
const app = express();
const server = http.createServer(app);
const io  = new Server(server);    //it'll handle the socket io

app.use(express.static('./public'))

app.get("/",(req,res)=>{
    // res.send("Hello World!")
    res.sendFile("index.html")
})

io.on('connection',(socket)=>{
    socket.on('chat msg',(msg)=>{
        // console.log(msg);
        io.emit('chat msg',msg);
    })
    console.log('a new client connected')
})

server.listen(PORT,()=>{
    console.log(`Server is running on port ${PORT}`);
})


