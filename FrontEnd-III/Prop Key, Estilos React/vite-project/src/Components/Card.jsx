import Button from "./Button";
import CardStyles from "../Styles/Card.module.css";
console.log(CardStyles);
const Card = ({ recipe }) => {
  // console.log(recipe)
  return (
    <div className={CardStyles.cardContainer}>
      <img src={recipe.img} alt="" className={CardStyles.cardImg} />
      <h3>{recipe.tipo}</h3>
      <h4>{recipe.precio}</h4>
      <Button>Ver detalle</Button>
    </div>
  );
};

export default Card;
