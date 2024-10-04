
importReact, { useEffect } from'react';
importtwitterLogo from'./assets/twitter-logo.svg';
import'./App.css';
// ConstantsconstTWITTER_HANDLE= '_buildspace';
constTWITTER_LINK= `https://twitter.com/${TWITTER_HANDLE}`;
constApp= () => {
 // ActionsconstcheckIfWalletIsConnected= async() => {
   try{
     const{ solana } = window;
if(solana) {
       if(solana.isPhantom) {
         console.log('Phantom wallet found!');
         constresponse = awaitsolana.connect({ onlyIfTrusted: true});
         console.log(
           'Connected with Public Key:',
           response.publicKey.toString()
         );
       }
     } else{
       alert('Solana object not found! Get a Phantom Wallet :ghost:');
     }
   } catch(error) {
     console.error(error);
   }
 };
/*
  * Let's define this method so our code doesn't break.
  * We will write the logic for this next!
  */constconnectWallet= async() => {};
/*
  * We want to render this UI when the user hasn't connected
  * their wallet to our app yet.
  */constrenderNotConnectedContainer= () => (
   <buttonclassName="cta-button connect-wallet-button"onClick={connectWallet}>Connect to Wallet
   </button>);
// UseEffectsuseEffect(() =>{
   constonLoad= async() => {
     awaitcheckIfWalletIsConnected();
   };
   window.addEventListener('load', onLoad);
   return() =>window.removeEventListener('load', onLoad);
 }, []);
return(
   <divclassName="App"><divclassName="container"><divclassName="header-container"><pclassName="header">🖼 GIF Portal</p><pclassName="sub-text">View your GIF collection in the metaverse :sparkles:
         </p>{/* Render your connect to wallet button right here */}
         {renderNotConnectedContainer()}
       </div><divclassName="footer-container"><imgalt="Twitter Logo"className="twitter-logo"src={twitterLogo}/><aclassName="footer-text"href={TWITTER_LINK}target="_blank"rel="noreferrer">{`built on @${TWITTER_HANDLE}`}</a></div></div></div>);
};
exportdefaultApp;