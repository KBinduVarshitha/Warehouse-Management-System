import React,{useEffect,useState} from "react";

import {
getInventory
} from "../services/inventoryService";


function Inventory(){


const [items,setItems]=useState([]);



useEffect(()=>{


getInventory()

.then(res=>{

setItems(res.data);

});


},[]);




return(

<div>


<h2>
Inventory
</h2>



<table>


<thead>

<tr>

<th>
Product
</th>


<th>
Quantity
</th>


</tr>

</thead>



<tbody>


{

items.map(item=>(


<tr key={item.id}>


<td>

{item.product.name}

</td>


<td>

{item.quantity}

</td>


</tr>


))


}


</tbody>


</table>


</div>


);


}


export default Inventory;