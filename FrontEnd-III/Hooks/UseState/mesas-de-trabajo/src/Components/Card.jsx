import Button from "./Button";
import CardStyles from "../Styles/Card.module.css"

const Card = ({ tarea, tasks, setTasks }) => {
  return (
    <div className={CardStyles.cardContainer}>
      <img src={tarea.img} alt="" className={CardStyles.cardImg} />
      <h3>{tarea.descripcion}</h3>
      <Button onClick={() => setTasks([...tasks, tarea])}>Agregar Tarea</Button>
    </div>
  );
};

export default Card;