import "./Styles/App.css";
import LifeCycles from "./Components/LifeCycles";
import { useState } from "react";

function App() {
  const [toggle, setToggle] = useState(true);
  return (
    <>
      {toggle && <LifeCycles />}
      <button onClick={() => setToggle(!toggle)}>
        {toggle ? "Desmontar" : "Montar"} Componente
      </button>
    </>
  );
}

export default App;
