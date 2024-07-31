import "./App.css";
import Card from "./Components/Card";
import Navbar from "./Components/Navbar";
import Contact from "./Components/Contact";

function App() {
  return (
    <>
      <Navbar />
      <h1>Bienvenidos a Vite</h1>
      <Card nombre="Germán" email={"germfra@gmail.com"} />
      <Card nombre="Joshua" email={"joshta@yahoo.com.ar"} />
      <Card nombre="Claudia" email={"claulnj@hotmail.com"} />
      <Contact />
    </>
  );
}

export default App;
