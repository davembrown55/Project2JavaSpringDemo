import React, { useEffect } from "react";
import { useState, useRef } from "react";
//import { useNavigate} from "react-router-dom";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from'react-bootstrap/Col';
import styles from './Sellers.styles.css'
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"></link>


const SellerForm = () => {
    const [sellertitle, setsellerTitle] = useState('');
    const [sellerfirstname, setsellerFname] = useState('');
    const [sellersurname, setsellerSurname] = useState('');
    const [selleraddress, setsellerAddress] = useState('');
    const [sellerpostcode, setsellerPostcode] = useState('');
    const [sellerphone, setsellerPhone] = useState('');

    const [items, setItems] = useState([]);
    const [dataIsLoaded, setdataIsLoaded ] = useState(false);

  useEffect(()=> {
    fetch(
      "http://localhost:8080/api/seller")
          .then((res) => res.json())
          .then((json) => {
            setItems(json)
            setdataIsLoaded(true)
          })
  },[])

    //const navigate = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();
        const sellers = {
        title: sellertitle,
        firstName: sellerfirstname,
        surname: sellersurname,
        address: selleraddress,
        postcode: sellerpostcode,
        phone: sellerphone
        };


    fetch(`http://localhost:8080/api/seller`, {
     method: 'POST',
      headers: { "Content-Type": "application/json" },
     body: JSON.stringify(sellers)
   })
   .then(response => {
   if (response.ok) console.log ("success")
   else return (response.json())
   })
   .catch(error => {
   console.log (error)
   })
   setsellerTitle('');
   setsellerFname('');
   setsellerSurname('');
   setsellerAddress('');
   setsellerPostcode('');
   setsellerPhone('');
}

   return (
    <>
        <Form onSubmit = {handleSubmit}>
          <Form.Label>Enter new seller</Form.Label>
            <Row className="mb-3">
            <Form.Group as={Col} controlId="formtitle">

        <Form.Label>Title</Form.Label>
        <Form.Select aria-label="Default" value={sellertitle} onChange={(e) => setsellerTitle(e.target.value)}>
        <option>Choose</option>
        <option value="Mr" onChange={(e) => setsellerTitle(e.target.value)}>Mr</option>
        <option value="Miss"onChange={(e) => setsellerTitle(e.target.value)}>Miss</option>
        <option value="Mrs"onChange={(e) => setsellerTitle(e.target.value)}>Mrs</option>
        <option value="Dr" onChange={(e) => setsellerTitle(e.target.value)}>Dr</option>
        </Form.Select>
      </Form.Group>
        <Form.Group as={Col}  controlId="formfirstname">
        <Form.Label>First name</Form.Label>
        <Form.Control type="sellerfirstname"  value={sellerfirstname} onChange={(e) => setsellerFname(e.target.value)}/>
        <Form.Text className="text-muted">
        </Form.Text>
      </Form.Group>
      <Form.Group as={Col} controlId="formBsurname">
        <Form.Label>Surname</Form.Label>
        <Form.Control type="ssellersurname"  value={sellersurname} onChange={(e) => setsellerSurname(e.target.value)}/>
        <Form.Text className="text-muted" >
        </Form.Text>
      </Form.Group>
      </Row>
      <Form.Group className="mb-3" controlId="formaddress">
        <Form.Label>Address</Form.Label>
        <Form.Control type="address"  value={selleraddress} onChange={(e) => setsellerAddress(e.target.value)}/>
        <Form.Text className="text-muted">
        </Form.Text>
      </Form.Group>
      <Row className="mb-3">
      <Form.Group as={Col} controlId="formpostcode">
        <Form.Label>Postcode</Form.Label>
        <Form.Control type="postcode" value={sellerpostcode} onChange={(e) => setsellerPostcode(e.target.value)}/>
        <Form.Text className="text-muted fs-2" >
        </Form.Text>
      </Form.Group>
      <Form.Group as={Col} controlId="formphone">
        <Form.Label>Contact</Form.Label>
        <Form.Control type="phone" value={sellerphone} onChange={(e) => setsellerPhone(e.target.value)}/>
        <Form.Text className="text-muted">
        </Form.Text>
      </Form.Group>
      </Row>
      <Button variant="primary" type="submit">
        Add seller
      </Button>
    </Form>
    {
      dataIsLoaded && <><h1> All sellers </h1> {
      items.map((item) => (
        <div id="accordion">
        <div class="card">
          <div class="card-header" id="headingOne">
            <h5 class="mb-0">
              <button class="btn" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                {item.id}&nbsp;{item.firstName}&nbsp;{item.surname}
              </button>
              <button class="delete">Delete</button>
              <button class="update">Update</button>
              
            </h5>
          </div>
          <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
            <div class="card-body">
              {item.address}&nbsp;{item.postcode}&nbsp;{item.phone}
            </div>
          </div>
        </div>
        </div>
      // <ol key = {item.id} >
      // First_Name: {item.firstName },
      // Sur_Name: { item.surname },
      // User_Address: {item.address },
      // Post_Code: {item.postcode},
      // Phone_Number: {item.phone}
      // </ol>
      ))
      }
      </>
      }
  </>
   )
}

export default SellerForm;