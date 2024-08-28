import Button from "./Button";
import CardStyles from "../Styles/Card.module.css";
import Counter from "./Counter";
import { Link } from "react-router-dom";

const Card = ({ recipe, cart, setCart }) => {
  return (
    <div className={CardStyles.cardContainer}>
      <img src={recipe.image} alt="" className={CardStyles.cardImg} />
      <h3>{recipe.title}</h3>
      <h4>${recipe.pricePerServing}</h4>
      <Counter />
      <Button onClick={() => setCart([...cart, recipe])}>🛒</Button>
      <Link to={"/detail/" + recipe.id}>
        {/* Navegación dinámica para ver componente Detail */}
        <Button>Ver detalle</Button>
      </Link>
    </div>
  );
};

export default Card;
