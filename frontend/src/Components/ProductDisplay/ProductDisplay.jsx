import React from 'react'
import './ProductDisplay.css'
// import star_dull_icon from '../Assets/star_dull_icona.png'
import star_icon from '../Assets/star_icon.png'

export default function ProductDisplay(props) {

    const { product } = props;

  return (
    <div className='productdisplay'>
      <div className="ProductDisplay-left">
        <div className="ProductDisplay-img-list">
            <img src={product.img} alt="" />
            <img src={product.img} alt="" />
            <img src={product.img} alt="" />
            <img src={product.img} alt="" />
        </div>
        <div className="productdisply-img">
            <img className='productdisply-main-img' src={product.img} alt="" />
        </div>
      </div>
      <div className="ProductDisplay-right">
        <h1>{product.name}</h1>
        <div className="product-right-stra">
            <img src={star_icon} alt="" />
            <img src={star_icon} alt="" />
            <img src={star_icon} alt="" />
            <img src={star_icon} alt="" />
            {/* <img src={star_dull_icon} alt="" /> */}
            <p>(122)</p>
        </div>
      </div>
    </div>
  )
}
