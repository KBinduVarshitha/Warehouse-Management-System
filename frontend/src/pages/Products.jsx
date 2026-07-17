import React,{useEffect,useState} from "react";

import {
getProducts,
addProduct
} from "../services/productService";


function Products(){


const [products,setProducts]=useState([]);


const [name,setName]=useState("");



useEffect(()=>{


loadProducts();


},[]);



const loadProducts=()=>{


getProducts()

.then(res=>{

setProducts(res.data);

});


};





const saveProduct=()=>{


addProduct({

name:name

})

.then(()=>{

alert("Product Added");

loadProducts();

});


};




return(

<div>


<h2>
Products
</h2>



<input

placeholder="Product name"

onChange={
(e)=>setName(e.target.value)
}

/>



<button onClick={saveProduct}>

Add Product

</button>



<hr/>



{

products.map(product=>(


<div key={product.productId}>


<h4>

{product.name}

</h4>


</div>


))

}



</div>

);


}


export default Products;