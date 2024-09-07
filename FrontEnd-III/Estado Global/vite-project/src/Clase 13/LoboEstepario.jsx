import React from "react";
import lobo from "./lobo.png";
import { useSalarioStates } from "./Context";
const LoboEstepario = () => {
  const { salario } = useSalarioStates();
  return (
    <div className="lobo-estepario">
      <img className="lobo" src={lobo} alt="lobo" />
      <h3>Total: {salario * 6}</h3>
      {console.log("Se renderizó el lobo")}
    </div>
  );
};

export default LoboEstepario;
