import Item from "./Components/Item";

function App() {
  const muebles = ["mesa", "ropero", "silla", "rack", "escritorio"];
  return (
    <div>
      {muebles.map((mueble, index) => {
        return <Item key={index} mueble={mueble} />;
      })}
    </div>
  );
}

export default App;