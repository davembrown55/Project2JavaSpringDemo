import React from "react"
import { useState, useEffect } from "react"
import styles from './Property.module.css'


// Button click for viewing booking

const HouseCard = ({ id, type, address, postcode, imageUrl, price, bedroom, bathroom, garden, forSale}) => {



    const [whenClicked, addCart] = useState(false);

    const flipButtonText = () => {    
        addCart((addCart) => !addCart);
    
   
 };

    return (
        <div className="items-grid">
            
                    <div key={id} className="item-card">
                    
                    <h3><em>{type}</em></h3>
                    <h4><em>{address},&nbsp;{postcode}</em></h4>
                    {/* <p><img src={require ("./Prop1.jpg")} className={styles.cardImage}  alt="" /></p> */}
                    <p><img src={imageUrl} className={styles.cardImage}  alt="" /></p>

                    <h3>£{price}</h3>
                    <p>{bedroom} Bedrooms &nbsp;&amp;&nbsp;{bathroom} Bathrooms. {garden} Garden </p>
                    <h3> Status: {forSale}  </h3>
                    <button onClick={flipButtonText} 
                    className={styles[whenClicked ? 'viewing-booked' : 'book-viewing']}
                    >
                        {whenClicked ? 'Viewing Booked' : 'Book Viewing' }          
                    </button>
                    
                 </div>

           
        </div>
    );
};


export default HouseCard;


