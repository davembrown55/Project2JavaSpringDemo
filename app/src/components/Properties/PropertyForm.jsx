import React from "react"
import { useState, useRef, useEffect } from "react"
import styles from './Property.module.css'
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from'react-bootstrap/Col';


const PropertyForm = () => {
        const [propAddress, setPropAddress] = useState('');
        const [propPostcode, setPropPostcode] = useState('');
        const [propPrice, setPropPrice] = useState('');
        const [propBedrooms, setPropBedrooms] = useState('');
        const [propBathrooms, setPropBathrooms] = useState('');
        const [propGarden, setPropGarden] = useState('');
        const [propType, setPropType] = useState('');
        const [propStatus, setPropStatus] = useState('');

        const [items, setItems] = useState([]);
        const [dataIsLoaded, setdataIsLoaded ] = useState(false);

        const handleSubmit = (event) => {
            event.preventDefault();
            const properties = {
            address: propAddress,
            postcode: propPostcode,
            price: propPrice,
            bedrooms: propBedrooms,
            bathrooms: propBathrooms,
            garden: propGarden,
            type: propType,
            status: propStatus,
            };

    fetch(`http://localhost:8080/api/properties`, {
     method: 'POST',
      headers: { "Content-Type": "application/json" },
     body: JSON.stringify(properties)
   })
   .then(response => {
   if (response.ok) console.log ("success")
   else return (response.json())
   })
   .catch(error => {
   console.log (error)
   })
   setPropAddress('');
   setPropPostcode('');
   setPropPrice('');
   setPropBedrooms('');
   setPropBathrooms('');
   setPropGarden('');
   setPropType('');
   setPropStatus('');
}


    return (
        <>
            <Form onSubmit = {handleSubmit}>
              <Form.Label>Enter new Property</Form.Label>

            <Row className="mb-3">
            <Form.Group as={Col} controlId="formPropStatus">
            <Form.Label>Status</Form.Label>
            <Form.Select aria-label="Default" value={propStatus} onChange={(e) => setPropStatus(e.target.value)}>
            <option>Choose</option>
            <option value="FORSALE" onChange={(e) => setPropStatus(e.target.value)}>For Sale</option>
            <option value="WITHDRAWN" onChange={(e) => setPropStatus(e.target.value)}>Withdrawn</option>
            <option value="SOLD" onChange={(e) => setPropStatus(e.target.value)}>Sold</option>
            </Form.Select>
            </Form.Group>

            <Form.Group as={Col} controlId="formPropType">
            <Form.Label>Type</Form.Label>
            <Form.Select aria-label="Default" value={propType} onChange={(e) => setPropType(e.target.value)}>
            <option>Choose</option>
            <option value="DETACHED" onChange={(e) => setPropType(e.target.value)}>Detached</option>
            <option value="SEMI" onChange={(e) => setPropType(e.target.value)}>Semi</option>
            <option value="APARTMENT" onChange={(e) => setPropType(e.target.value)}>Apartment</option>
            <option value="TERRACE" onChange={(e) => setPropType(e.target.value)}>Terrace</option>
            </Form.Select>
            </Form.Group>

            <Form.Group as={Col}  controlId="formPropPrice">
            <Form.Label>Price</Form.Label>
            <Form.Control type="propPrice"  value={propPrice} onChange={(e) => setPropPrice(e.target.value)}/>
            <Form.Text className="text-muted">
            </Form.Text>
            </Form.Group>
            </Row>

            <Form.Group classname="mb-3" controlId="formpropAddress">
                <Form.Label>Address</Form.Label>
                <Form.Control type="propAddress"  value={propAddress} onChange={(e) => setPropAddress(e.target.value)}/>
                <Form.Text className="text-muted">
            </Form.Text>
            </Form.Group>

            <Row className="mb-4">
            <Form.Group as={Col}  controlId="formPropPostcode">
                <Form.Label>Postcode</Form.Label>
                <Form.Control type="propPostcode"  value={propPostcode} onChange={(e) => setPropPostcode(e.target.value)}/>
                <Form.Text className="text-muted">
            </Form.Text>
            </Form.Group>

            <Form.Group as={Col}  controlId="formPropBedrooms">
            <Form.Label>Bedrooms</Form.Label>
            <Form.Control type="propBedrooms"  value={propBedrooms} onChange={(e) => setPropBedrooms(e.target.value)}/>
            <Form.Text className="text-muted">
            </Form.Text>
            </Form.Group>

            <Form.Group as={Col}  controlId="formPropBathrooms">
            <Form.Label>Bathrooms</Form.Label>
            <Form.Control type="propBathrooms"  value={propBathrooms} onChange={(e) => setPropBathrooms(e.target.value)}/>
            <Form.Text className="text-muted">
            </Form.Text>
            </Form.Group>

            <Form.Group as={Col}  controlId="formPropGarden">
            <Form.Label>Garden</Form.Label>
            <Form.Select aria-label="Default" value={propGarden} onChange={(e) => setPropGarden(e.target.value)}>
            <option>Choose</option>
            <option value="true" onChange={(e) => setPropGarden(e.target.value)}>Yes</option>
            <option value="false" onChange={(e) => setPropGarden(e.target.value)}>No</option>
            </Form.Select>
            </Form.Group>

            </Row>
            <Button variant="primary" type="submit">
               Add Property
            </Button>
           </Form>
            </>
//          ,
//       </>
       )
}
export default PropertyForm;