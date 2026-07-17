import API from "../api/axiosConfig";


export const getOrders=()=>{

    return API.get("/orders");

};



export const createOrder=(order)=>{

    return API.post(
        "/orders",
        order
    );

};



export const updateOrderStatus=(id,status)=>{

    return API.put(
        `/orders/${id}/status?status=${status}`
    );

};