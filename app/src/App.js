import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import SellerForm from './components/Sellers/SellerForm';
import BuyerForm from './components/Buyerform';
import LandingPage from './components/LandingPage';
import 'bootstrap/dist/css/bootstrap.min.css';
import styles from './App.css';
// import AllSellers from './components/AllSellers';
import Properties from './components/Properties/Properties.jsx'
import React, { useEffect, useState } from 'react';
import './App.css';


function App() {
// class App extends React.Component {
//     constructor(props) {
//     super(props);

//     this.state ={
//         items: [],
//         DataisLoaded: false
//         };
//     }

//     componentDidMount() {
//     fetch(
//     "http://localhost:8080/api/buyer")
//         .then((res) => res.json())
//         .then((json) => {
//             this.setState({
//                 items: json,
//                 DataisLoaded: true
//             });
//         })
//     }
//     render() {
//     const { DataisLoaded, items } = this.state;
//     if (!DataisLoaded) return <div>
//     <h1> Please wait </h1> </div> ;

  return (
    <div className="App">
      <BrowserRouter>
      <Navbar />
        <main>
          <Routes>
            <Route path="/seller" element={<SellerForm />} />
            {/* <Route path="/getAllSellers" element ={<SellerForm />} /> */}
            <Route path="/buyer" element={<BuyerForm />} />
            <Route path="/LandingPage" element={<LandingPage />}/>
            <Route path="/Properties" element={<Properties />} />
          </Routes>
        </main>
      </BrowserRouter>
    </div>
  );
}


export default App;