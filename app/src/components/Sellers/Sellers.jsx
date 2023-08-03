import React, {useEffect, useReducer, useState} from "react";
import {Panel} from 'react-bootstrap'


function Sellers () {

    const [data, setData] = useState ([]);

    useEffect(() => {
        //Fetch data from the JSON server
        fetch('http://localhost:8080/sellers')
            .then(response => response.json())
            .then(data => setData(data));

    }, []);

    const [query, setQuery] = useState("")


    return (
       <div className="App">
        <main>
            <h2>Sellers</h2>
            <div>
            <input placeholder="Search for seller" onChange={event => setQuery(event.target.value)}/>
            </div>
            <div className="items-grid">
                {data.filter(item => {
                    if (query === '') {
                        return item;
                    } else if (item.type.toLowerCase().includes(query.toLowerCase()) || (item.surname.toLowerCase().includes(query.toLowerCase()) || (item.address.toLowerCase().includes(query.toLowerCase()) || (item.postcode.toLowerCase().includes(query.toLowerCase()) )))) {
                        return item;
                    }
                }).map((item) =>(                
                    <div class="panel panel-primary">
                    <div class="panel-heading">
                      <h3 class="panel-title">{item.id}{item.firstName}{item.surname}</h3>
                    </div>
                    <div class="panel-body">
                      {item.address}{item.postcode}{item.phone}
                    </div>
                  </div>
                ))}
            </div>
        </main>
    </div>
    )};



export default Sellers