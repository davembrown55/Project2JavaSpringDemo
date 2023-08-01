import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import SellerForm from './components/Sellerform';
import BuyerForm from './components/Buyerform';
import LandingPage from './components/LandingPage';
import 'bootstrap/dist/css/bootstrap.min.css';
import styles from './App.css';
import AllSellers from './components/AllSellers';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Navbar />
        <main>
          <Routes>
            <Route path="/seller" element={<SellerForm />} />
            <Route path="/getAllSellers" element ={<AllSellers />} />
            <Route path="/buyer" element={<BuyerForm />} />
            <Route path="/LandingPage" element={<LandingPage />}/>
          </Routes>
        </main>

      </BrowserRouter>
    </div>
  );
}

export default App;

