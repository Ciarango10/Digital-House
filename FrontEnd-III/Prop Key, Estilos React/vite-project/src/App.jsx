import "./Styles/App.css";
import Navbar from "./Components/Navbar";
import Home from "./Components/Home";

function App() {
  let lista = ["Elemento 1", "Elemento 1", "Elemento 2", "Elemento 3"];
  // const mapLista = lista.map((item, index) => {
  //   return <li key={index}>{item}</li>;
  // });
  // console.log(mapLista);
  return (
    <>
      <Navbar />
      <Home />
      {/* <ul>{mapLista}</ul> */}
      {/* <ul>
        {lista.map((item, index) => {
          return <li key={index}>{item}</li>;
        })}
      </ul> */}
    </>
  );
}

export default App;
