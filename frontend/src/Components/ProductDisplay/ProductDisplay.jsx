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
              <img src={product.image} alt={`${product.name}`} />
              <img src={product.image} alt={`${product.name}`} />
              <img src={product.image} alt={`${product.name}`} />
              <img src={product.image} alt={`${product.name}`} />
        </div>
        <div className="productdisply-img">
            <img className='productdisply-main-img' src={product.image} alt={`${product.name}`} />
        </div>
      </div>
      <div className="ProductDisplay-right">
        <h1>{product.name}</h1>
        <div className="product-right-stars">
            <img src={star_icon} alt="Star Rating" />
            <img src={star_icon} alt="Star Rating" />
            <img src={star_icon} alt="Star Rating" />
            <img src={star_icon} alt="Star Rating" />
            {/* <img src={star_dull_icon} alt="Star Rating" /> */}
              <p>(122)</p>
        </div>
        <div className="productdisplay-right-prices">
          <div className="productdisplay-right-prices-old">${product.old_price}</div>
          <div className="productdisplay-right-prices-new">${product.new_price}</div>
        </div>
        <div className="productdisplay-right-description">
          {product.description}
        </div>
        <div className="productdisplay-right-size">
          <h3>Select Size</h3>
          <div className="productdisplay-right-sizes">
            <div className="">S</div>
            <div className="">M</div>
            <div className="">L</div>
            <div className="">XXL</div>
          </div>
        </div>
        <button>ADD TO CART</button>
        <p className="productdisplay-right-category"><span>Category : </span>Women , T-Shirt, Crop Top</p>
        <p className="productdisplay-right-category"><span>Tags : </span>Modern , Latest</p>
      </div>
    </div>
  )
}
