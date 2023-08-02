import { Link } from "react-router-dom";
export default function Navbar() {
    return (
        <nav>
            <h1>East Property Services</h1>
            <h5>For your new home, head east</h5>
            <ul>
                <li>
                <Link to ="/Properties">Properties</Link>
                </li>
                <li>
                    <Link to ="/buyer">Buyer</Link>
                </li>
                <li>
                    <Link to ="/seller">Add Seller</Link>
                </li>
                <li>
                    <Link to ="/getAllSellers">All Sellers</Link>
                </li>
                <li>
                    <Link to ="/LandingPage">Login</Link>
                </li>
            </ul>
        </nav>
    )
}