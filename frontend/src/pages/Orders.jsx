import React,{useEffect,useState} from "react";


import {
getOrders,
updateOrderStatus
} from "../services/orderService";



function Orders(){



const [orders,setOrders]=useState([]);




useEffect(()=>{


loadOrders();


},[]);




const loadOrders=()=>{


getOrders()

.then(res=>{

setOrders(res.data);

});


};




const packOrder=(id)=>{


updateOrderStatus(
id,
"PACKED"
)

.then(()=>{


alert(
"Order Packed"
);


loadOrders();


});


};




return(

<div>


<h2>
Orders
</h2>



{

orders.map(order=>(


<div key={order.orderId}>


<p>

Product:
{order.product.name}

</p>


<p>

Quantity:
{order.quantity}

</p>


<p>

Status:
{order.status}

</p>



<button

onClick={
()=>packOrder(order.orderId)
}

>

PACK

</button>


<hr/>


</div>


))


}



</div>


);


}


export default Orders;