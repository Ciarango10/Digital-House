import React from "react";
import Navbar from "../Components/Navbar";
import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <div>
      <Navbar />
      <Outlet />
      {/* Acá iria el footer */}
    </div>
  );
};

export default Layout;
