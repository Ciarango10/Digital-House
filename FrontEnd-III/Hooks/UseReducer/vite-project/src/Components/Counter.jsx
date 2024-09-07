import { useState } from "react";
import CardStyles from "../Styles/Card.module.css";
import Button from "./Button";

const Counter = () => {
  //   let contador = 0; No se usa

  const [counter, setCounter] = useState(0);

  const sumar = () => {
    // counter++; // ❌ NO FUNCIONA
    setCounter(counter + 1);
    console.log(counter);
  };
  const restar = () => {
    // counter--;
    setCounter(counter - 1);
    console.log(counter);
  };

  return (
    <div className={CardStyles.btnGroup}>
      <Button disabled={counter == 0} onClick={restar}>
        -
      </Button>
      <h4>{counter}</h4>
      <Button onClick={sumar}>+</Button>
    </div>
  );
};

export default Counter;
