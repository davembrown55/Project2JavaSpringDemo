import React, {useEffect, useReducer, useState} from "react";
// import {Link} from "react-router-dom";
import "./property.css";
import Housecard from './HouseCard';

const Properties =  () => {
    const [data, setData] = useState ([]);

    useEffect(() => {
        //Fetch data from the JSON server
        fetch('http://localhost:8000/property')
            .then(response => response.json())
            .then(data => setData(data));

    }, []);

    const [query, setQuery] = useState("")


    return (
    <div>
        <div>
       
       <div className="App">
        <main>
            <h2>Browse our Properties</h2>
            <div>
            <input placeholder="Search for properties" onChange={event => setQuery(event.target.value)}/>
            </div>

            <div className="items-grid">
                {data.filter(item => {
                    if (query === '') {
                        return item;
                    } else if (item.type.toLowerCase().includes(query.toLowerCase()) || (item.forSale.toLowerCase().includes(query.toLowerCase()) || (item.address.toLowerCase().includes(query.toLowerCase()) || (item.postcode.toLowerCase().includes(query.toLowerCase()) )))) {
                        return item;
                    }
                }).map((item) =>(
                // {data.map((item) => (
                   
                    <Housecard 
                    id={item.id}
                    type={item.type}
                    address={item.address}
                    postcode={item.postcode}
                    imageUrl={item.imageUrl}
                    price={item.price}
                    bedroom={item.bedroom}
                    bathroom={item.bathroom}
                    garden={item.garden}
                    forSale={item.forSale}                    
                    />    
                    
                    ))}
           
            
            </div>

            
        </main>
    </div>

        </div>
    </div>
    )
} 

export default Properties