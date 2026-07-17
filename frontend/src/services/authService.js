import API from "../api/axiosConfig";


export const login = async(data)=>{

    const response =
        await API.post("/auth/login",data);


    localStorage.setItem(
        "token",
        response.data
    );


    return response.data;

};



export const register = async(data)=>{

    return await API.post(
        "/auth/register",
        data
    );

};



export const logout=()=>{

    localStorage.removeItem("token");

};