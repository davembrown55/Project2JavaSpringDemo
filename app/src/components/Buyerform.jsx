import React, { useEffect } from "react";
import { useState, useRef } from "react";
//import { useNavigate} from "react-router-dom";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from'react-bootstrap/Col';


const BuyerForm = () => {
    const [buyertitle, setBuyerTitle] = useState('');
    const [buyerfirstname, setBuyerFname] = useState('');
    const [buyersurname, setBuyerSurname] = useState('');
    const [buyeraddress, setBuyerAddress] = useState('');
    const [buyerpostcode, setBuyerPostcode] = useState('');
    const [buyerphone, setBuyerPhone] = useState('');

    const [items, setItems] = useState([]);
    const [dataIsLoaded, setdataIsLoaded ] = useState(false);

  useEffect(()=> {
    fetch(
      "http://localhost:8080/api/buyer")
          .then((res) => res.json())
          .then((json) => {
            setItems(json)
            setdataIsLoaded(true)
          })
  },[])

    //const navigate = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();
        const buyers = {
        title: buyertitle,
        firstName: buyerfirstname,
        surname: buyersurname,
        address: buyeraddress,
        postcode: buyerpostcode,
        phone: buyerphone
        };


    fetch(`http://localhost:8080/api/buyer`, {
     method: 'POST',
      headers: { "Content-Type": "application/json" },
     body: JSON.stringify(buyers)
   })
   .then(response => {
   if (response.ok) console.log ("success")
   else return (response.json())
   })
   .catch(error => {
   console.log (error)
   })
   setBuyerTitle('');
   setBuyerFname('');
   setBuyerSurname('');
   setBuyerAddress('');
   setBuyerPostcode('');
   setBuyerPhone('');
}

   return (
    <>
        <Form onSubmit = {handleSubmit}>
          <Form.Label>Enter new Buyer</Form.Label>
         <Row className="mb-3">
         <Form.Group as={Col} controlId="formtitle">

        <Form.Label>Title</Form.Label>
        <Form.Select aria-label="Default" value={buyertitle} onChange={(e) => setBuyerTitle(e.target.value)}>
        <option>Choose</option>
        <option value={buyertitle} onChange={(e) => setBuyerTitle(e.target.value)}>Mr</option>
        <option value={buyertitle} onChange={(e) => setBuyerTitle(e.target.value)}>Miss</option>
        <option value={buyertitle} onChange={(e) => setBuyerTitle(e.target.value)}>Mrs</option>
        <option value={buyertitle} onChange={(e) => setBuyerTitle(e.target.value)}>Dr</option>
        </Form.Select>
      </Form.Group>
        <Form.Group as={Col}  controlId="formBfirstname">
        <Form.Label>First name</Form.Label>
        <Form.Control type="buyerfirstname"  value={buyerfirstname} onChange={(e) => setBuyerFname(e.target.value)}/>
        <Form.Text className="text-muted">
        </Form.Text>
      </Form.Group>
      <Form.Group as={Col} controlId="formBsurname">
        <Form.Label>Surname</Form.Label>
        <Form.Control type="sbuyersurname"  value={buyersurname} onChange={(e) => setBuyerSurname(e.target.value)}/>
        <Form.Text className="text-muted" >
        </Form.Text>
      </Form.Group>
      </Row>
      <Form.Group className="mb-3" controlId="formaddress">
        <Form.Label>Address</Form.Label>
        <Form.Control type="address"  value={buyeraddress} onChange={(e) => setBuyerAddress(e.target.value)}/>
        <Form.Text className="text-muted">
        </Form.Text>
      </Form.Group>
      <Row className="mb-3">
      <Form.Group as={Col} controlId="formpostcode">
        <Form.Label>Postcode</Form.Label>
        <Form.Control type="postcode" value={buyerpostcode} onChange={(e) => setBuyerPostcode(e.target.value)}/>
        <Form.Text className="text-muted fs-2" >
        </Form.Text>
      </Form.Group>
      <Form.Group as={Col} controlId="formphone">
        <Form.Label>Contact</Form.Label>
        <Form.Control type="phone" value={buyerphone} onChange={(e) => setBuyerPhone(e.target.value)}/>
        <Form.Text className="text-muted">
        </Form.Text>
      </Form.Group>
      </Row>
      <Button variant="primary" type="submit">
        Add buyer
      </Button>
    </Form>
    {
      dataIsLoaded && <><h1> All Buyers </h1> {
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
//       <ol key = {item.id} >
//       First_Name: {item.firstName },
//       Sur_Name: { item.surname },
//       User_Address: {item.address },
//       Post_Code: {item.postcode},
//       Phone_Number: {item.phone}
//       </ol>
      ))
      }
      </>
      }
  </>
   )
}

export default BuyerForm;