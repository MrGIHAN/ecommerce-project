import React from 'react'
import './Footer.css'
import footer_log from '../Assets/logo_big.png'
import instagram_icon from '../Assets/instagram_icon.png'
import whatsapp_icon from '../Assets/whatsapp_icon.png'
import pintester_icon from '../Assets/pintester_icon.png'


export default function Footer() {
  return (
    <div className='Footer'>
      <div className="footer-logo">
        <img src={footer_log} alt="footer_logo" />
        <p>SHOPPER</p>
      </div>
        <ul className='footer-links'>
            <li>Company</li>
            <li>Products</li>
            <li>Offices</li>
            <li>About</li>
            <li>Contact</li>
        </ul>
        <div className="footer-social-icon">
            <div className="footer-icons-container">
                <img src={instagram_icon} alt="instagram_icon" />
            </div>
            <div className="footer-icons-container">
                <img src={whatsapp_icon} alt="whatsapp_icon" />
            </div>
            <div className="footer-icons-container">
                <img src={pintester_icon} alt="pintester_icon" />
            </div>
        </div>
        <div className="footer-copyright">
            <hr />
            <p>Copyright @ 2024 - All Right Reserved.</p>
        </div>
    </div>
  )
}
