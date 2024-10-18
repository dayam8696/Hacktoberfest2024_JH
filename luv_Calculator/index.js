
var percent = Math.floor(Math.random() * 101);


function Calc(){
    
var Area1 = document.querySelector(".TA1").value;
var Area2 = document.querySelector(".TA2").value;


    if(Area1!="" && Area2!=""){
    if(percent>0 &&  percent<=30){
        document.querySelector("p").innerText="Don't Worry, Try Again With New Partner 😄";
    }
    else if(percent<60 && percent>30){
        document.querySelector("p").innerText="Wow! Nice Percent, Carry On and keep Loving 🥰";
    }
    else if(percent<90 && percent>=60){
        document.querySelector("p").innerText="You Both Are Made For Each Other ❣️";
    }
    else if(percent<100 && percent>=90){
        document.querySelector("p").innerText="!!Exception Exist in our world just like you both, You are Soulmates from Births 💞";
    }
    console.log("selected var" );
    document.querySelector("button").innerHTML=percent + " %";

    document.querySelector("button").style.fontSize = "3rem";

    setTimeout(() => { document.location.reload(); }, 4000);
    setTimeout();
}
else{
    alert("Please fill in both names!!")
}
}
