import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SanphamList from './components/sanphamlist';
import SanphamForm from './components/sanphamform';
import TrangchuList from './components/trangchulist';
import DsdhList from './components/dsdhlist';
import SaleList from './components/salelist';
import CardList from './components/cartlist';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path='/sanpham' element={<SanphamList/>}/>
        <Route path='/sanpham/create' element={<SanphamForm/>}/>
        <Route path='/sanpham/update/:ma_sp' element={<SanphamForm/>}/>
        <Route path='/Trangchu' element={<TrangchuList/>}/>
        <Route path='/Hoadon' element={<DsdhList/>}/>
        <Route path='/Sale' element={<SaleList/>}/>
        <Route path='/Cart' element={<CardList/>}/>
      </Routes>
    </Router>
  );
};

export default App;
