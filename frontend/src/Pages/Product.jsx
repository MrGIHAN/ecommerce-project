import React, { useContext } from 'react';
import { ShopContext } from '../Context/ShopContext';
import { useParams } from 'react-router-dom';
import Breadcrum from '../Components/Breadcrums/Breadcrum';
import ProductDisplay from '../Components/ProductDisplay/ProductDisplay';

const Product = () => {
    const { all_products } = useContext(ShopContext); // Use the correct key
    const { productId } = useParams();

    if (!all_products) {
        return <div>Loading...</div>;
    }

    const product = all_products.find((e) => e.id === Number(productId));

    if (!product) {
        return <div>Product not found</div>;
    }

    return (
        <div>
            <Breadcrum product={product}/>
            <ProductDisplay product={product} /> 
        </div>
    );
};

export default Product;
