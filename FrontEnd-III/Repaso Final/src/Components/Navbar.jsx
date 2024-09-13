import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <div>
      <Link to="/">
        <h4>Home</h4>
      </Link>
      <Link to="/favs">
        <h4>Favs</h4>
      </Link>
      {/* Boton de cambio de tema */}
    </div>
  );
};

export default Navbar;
