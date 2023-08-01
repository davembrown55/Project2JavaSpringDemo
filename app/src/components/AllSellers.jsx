import React, {useState, useEffect, setQuery} from "react";
import {Link} from "react-router-dom";
import Sellercard from './SellerCard';
import styles from '../Sellercard.css';
import Navbar from './Navbar';
import {Button,ButtonGroup,Container,Table} from 'reactstrap';


 const AllSellers = () => {
    const [sellers, setSellers] = useState ([]);
    const [loading,setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        //Fetch data from the JSON server
        fetch('/getAllSellers/')
            .then(response => response.json())
            .then(data => {
            setSellers(data);
            setLoading(false);
    })
    },[]);

     const remove = async (id) => {
        await fetch(`removeSeller/${id}`,{
        method: 'DELETE',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'}
        }).then(() => {
        let updatedSellers = [...sellers].filter(i => i.id !==id);
        setSellers(updatedSellers);
        });
        }

    if(loading){
    return <p>...Loading</p>
    }
        const sellerList = sellers.map(seller => {
        const address = `${seller.title || ''}${seller.firstname || ''}${seller.address || ''}${seller.postcode || ''}${seller.phone || ''}`;
        return <tr key ={seller.id}>
        <td style={{whiteSpace:'nowrap'}}>{seller.name}</td>
            <td>{address}</td>
            <td>
            <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"east/getAllSellers" + seller.id}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => remove(seller.id)}>Delete</Button>
            </ButtonGroup>
            </td>
            </tr>
        });
        return (
        <div>
        <Navbar/>
        <Container fluid>
            <div className="float-end">
                <Button color="success" tag={Link} to="/saveSeller">Add Seller</Button>
                </div>
                <h3>Sellers Page</h3>
                <Table className="mt-4">
                <thead>
                <tr>
                    <th width ="5%">Title</th>
                    <th width ="10%">First Name</th>
                    <th width = "15%">Surname</th>
                    <th width="45%">Address</th>
                    <th width="15%">Postcode</th>
                    <th width ="15%">Phone</th>
                </tr>
                </thead>
                <tbody>
                {sellerList}
                </tbody>
                </Table>
                </Container>
                </div>

        /* <div>
            <div>
           <div className="allSellers">
            <main>
                <h2>Sellers List</h2>
                <div className="items-grid">
                    {data.map((item) => (
                        <Sellercard
                        title={item.title}
                        firstname={item.firstname}
                        surname={item.surname}
                        address={item.address}
                        postcode={item.postcode}
                        phone={item.phone}
                        />
                        ))}
                </div>
            </main>
        </div>
            </div>
        </div> */
        )
    }

    export default AllSellers;