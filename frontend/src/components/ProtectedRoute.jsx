import React from "react";


function ProtectedRoute({children}){


const token =
localStorage.getItem("token");



return token ? children : <h3>Login Required</h3>;

}


export default ProtectedRoute;