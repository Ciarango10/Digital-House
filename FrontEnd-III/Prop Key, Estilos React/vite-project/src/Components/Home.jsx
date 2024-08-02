import Card from "./Card";
import { pizzas } from "../utils/pizzas";

const titleStyles = {
  backgroundColor: "#ffda92",
  color: "firebrick",
  width: "20%",
  margin: "10px auto",
  borderRadius: "10px",
};

const Home = () => {
  return (
    <>
      <h1 style={titleStyles}>Lista de pizza</h1>
      <div className="list-container">
        {pizzas.map((pizza) => (
          <Card key={pizza.id} recipe={pizza} />
        ))}
      </div>
    </>
  );
};

export default Home;
