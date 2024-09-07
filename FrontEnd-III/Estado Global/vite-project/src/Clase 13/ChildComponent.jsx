import React, { useContext, useState } from "react";
import { SalarioStates, useSalarioStates } from "./Context";

const ChildComponent = () => {
  const { salario, setSalario } = useSalarioStates();
  // const { salario, setSalario } = useContext(SalarioStates);
  console.log("Render ChildComponent");
  return (
    <div className="child">
      <h3>ChildComponent</h3>
      <p>Cuanto ganas por semestre?</p>
      <h3>Total: {salario * 6} </h3>
      <button onClick={() => setSalario(salario + 100000)}>
        Aumentar Salario
      </button>
    </div>
  );
};

export default ChildComponent;
