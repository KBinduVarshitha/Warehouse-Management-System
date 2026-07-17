import API from "../api/axiosConfig";


export const getInventory=()=>{

    return API.get("/inventory");

};


export const updateStock=(id,data)=>{

    return API.put(
        `/inventory/${id}`,
        data
    );

};