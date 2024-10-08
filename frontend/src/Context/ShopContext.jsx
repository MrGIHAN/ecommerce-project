import React, { createContext } from 'react';
import all_products from '../Components/Assets/all_product';

export const ShopContext = createContext(null);

const ShopProvider = (props) => {
    const contextValue = { all_products }; // Ensure consistency in naming

    return (
        <ShopContext.Provider value={contextValue}>
            {props.children}
        </ShopContext.Provider>
    );
}

export default ShopProvider;
