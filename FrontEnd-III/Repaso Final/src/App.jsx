import { Route, Routes } from "react-router-dom";
import "./App.css";
import Home from "./Pages/Home";
import Favs from "./Pages/Favs";
import Detail from "./Pages/Detail";
import Navbar from "./Components/Navbar";
import Layout from "./Layouts/Layout";

function App() {
  return (
    <>
      {/* <Navbar /> */}
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home />} />
          {/* <Route path='/home' element={<h1>Home</h1>}/>       */}
          <Route path="/favs" element={<Favs />} />
          <Route path="/detail/:id" element={<Detail />} />
          <Route path="*" element={<h1>Page not Found</h1>} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
