import Button from "./Button";
import CardStyles from "../Styles/Card.module.css";
import Counter from "./Counter";

const Card = ({ recipe, cart, setCart }) => {
  return (
    <div className={CardStyles.cardContainer}>
      <img src={recipe.image} alt="" className={CardStyles.cardImg} />
      <h3>{recipe.title}</h3>
      <h4>${recipe.pricePerServing}</h4>
      <Counter />
      <Button onClick={() => setCart([...cart, recipe])}>🛒</Button>
      <Button>Ver detalle</Button>
    </div>
  );
};

export default Card;
