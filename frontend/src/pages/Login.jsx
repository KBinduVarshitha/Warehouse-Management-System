import React,{useState} from "react";
import {login} from "../services/authService";


function Login(){


const [username,setUsername]=useState("");
const [password,setPassword]=useState("");



const submit=async()=>{

    await login({
        username,
        password
    });

    window.location.href="/dashboard";

};



return(

<div>

<h2>WMS Login</h2>


<input
placeholder="Username"
onChange={(e)=>setUsername(e.target.value)}
/>


<input
type="password"
placeholder="Password"
onChange={(e)=>setPassword(e.target.value)}
/>


<button onClick={submit}>
Login
</button>


</div>

);


}


export default Login;