import React, {useEffect, useReducer, useState} from "react";
import "./property.css";
import Housecard from './HouseCard';
import PropertyForm from './PropertyForm';

function Properties () {

    const [data, setData] = useState ([]);

    //const [items, setItems] = useState([]);
    const [dataIsLoaded, setdataIsLoaded ] = useState(false);


//Fetch data from the JSON server
//     useEffect(() => {
//         fetch('http://localhost:8000/property')
//             .then(response => response.json())
//             .then(data => setData(data));
//
//     }, []);
      useEffect(()=> {
        fetch(
          "http://localhost:8080/api/properties")
              .then((res) => res.json())
              .then((json) => {
                setData(json)
                setdataIsLoaded(true)
              })
      },[])


    const [query, setQuery] = useState("")

//         const handleSubmit = (event) => {
//             event.preventDefault();
//             const buyers = {
//             title: buyertitle,
//             firstName: buyerfirstname,
//             surname: buyersurname,
//             address: buyeraddress,
//             postcode: buyerpostcode,
//             phone: buyerphone
//             };

    return (
    <div>
        <div>
       
       <div className="App">
        <main>
            <PropertyForm/>

            <h2>Current Properties</h2>
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