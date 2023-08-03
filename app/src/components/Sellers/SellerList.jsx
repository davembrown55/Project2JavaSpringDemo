import React from "react"
import { useState, useEffect } from "react"



// Button click for viewing booking

const SellerList = ({ id, name, address, postcode, phone}) => {



    const [whenClicked, addCart] = useState(false);

    const flipButtonText = () => {    
        addCart((addCart) => !addCart);
    
   
 };

    return (
        <div className="items-grid">
                    <div className="item-list">
                    <tbody>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Postcode</th>
                            <th>Phone</th>
                        </tr>
                    
                    </tbody>
                    
                 </div>

           
        </div>
    );
};


export default SellerList;


