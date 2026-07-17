import API from "../api/axiosConfig";


export const getProducts=()=>{

    return API.get("/products");

};


export const addProduct=(product)=>{

    return API.post(
        "/products",
        product
    );

};


export const deleteProduct=(id)=>{

    return API.delete(
        `/products/${id}`
    );

};