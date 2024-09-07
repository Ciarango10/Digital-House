import React from "react";
import { useRecipeStates } from "../Context/Context";
import Card from "../Components/Card";

const Cart = () => {
  const { cart } = useRecipeStates();
  return (
    <div>
      <h2>Recetas agregadas al carrito</h2>
      {cart.map((recipe) => (
        <Card key={recipe.id} recipe={recipe} />
      ))}
    </div>
  );
};

export default Cart;
