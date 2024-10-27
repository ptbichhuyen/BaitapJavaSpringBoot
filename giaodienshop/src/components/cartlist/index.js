import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "./cart.css";
import gau from '../../assets/images/gau1.jpeg';

const CartList=() => {
    const [products, setProducts] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');
    // const [loading, setLoading] = useState(true);
    // const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8080/Sanpham/getAllSanpham')
        .then(response => {
            const sanphamData = response.data;
            setProducts(sanphamData);
            console.log(sanphamData);
        })
        .catch(error => console.error('Error fetching product:', error));
    }, []);
    const filteredProducts = products.filter(product =>
        product.ten_sp.toLowerCase().includes(searchQuery.toLowerCase()) ||
        product.so_luong_ton.toString().includes(searchQuery.toString()) ||
        product.gia.toString().includes(searchQuery.toString()) ||
        product.mo_ta.toString().includes(searchQuery.toString()) ||
        product.ma_loai.toString().includes(searchQuery.toString())
    );
    return (
        <div>
            <div id="wrapper">
            <div id="header">
            <a href="" class="logo">
            </a>
            <div id="menu">
                <div class="item">
                    <a href="/Trangchu">TRANG CHỦ</a>
                </div>
                <div class="item">
                    <a href="/Cart">SẢN PHẨM</a>
                </div>
                <div class="item">
                    <a href="/Sale">SALE</a>
                </div>
                <div class="item">
                    <a href="https://www.facebook.com/profile.php?id=100095235735695">LIÊN HỆ</a>
                </div>
            </div>
                <div class="search">
                    <input type="text" placeholder=""/>
                </div>
                <div id="actions">
                    <div class="item">
                        <div class="submenu">
                            <button onclick="logout()">Đăng xuất</button>
                        </div>
                    </div>
                    <div class="item">
                        <div class="shopping">
                            <span class="quantity">0</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <header>
                    <h1>Tất cả sản phẩm </h1>
                </header>
                <div class="wp-products">
                <ul id="list-products">
                    {filteredProducts.map(sp=>(
                    <div class="item" key={sp.ma_sp}>
                        <img src={gau} alt=''/>
                        <div class="stars">
                            <span>
                                <img src="hinh/icons8-star-30.png" alt="" />
                            </span>
                            <span>
                                <img src="hinh/icons8-star-30.png" alt="" />
                            </span>
                            <span>
                                <img src="hinh/icons8-star-30.png" alt="" />
                            </span>
                            <span>
                                <img src="hinh/icons8-star-30.png" alt=""/>
                            </span>
                            <span>
                                <img src="hinh/icons8-star-30.png" alt="" />
                            </span>
                        </div>
                        <div class="name">{sp.ten_sp}</div>
                        <div class="price">{sp.gia} VNĐ</div>
                        <button class="them">Thêm</button>
                    </div>
                    ))}
                    </ul>
                </div>
            </div>
            <div class="card">
                <h1><b>Giỏ Hàng</b></h1>
                <ul class="listCard"></ul>
                <div class="checkOut">
                    <div class="total" onclick="dathang()">0</div>
                    <div class="closeShopping">Thoát</div>
                </div>
            </div>

            <div class="add-pd">
                <div class="add-pd-content">
                    <h2>THÔNG TIN KHÁCH HÀNG</h2>
                    <form id="add-pro">
                        <p>Thông Tin Khách Hàng</p>
            
                        <label for="kh-name">Tên Khách Hàng:</label>
                        <input type="text" name="tenkh" placeholder="Tên Khách Hàng..." id="kh-name"/>
                        <label for="kh-diachi">Địa chỉ:</label>
                        <input type="text" name="diachi" placeholder="Địa chỉ..." id="kh-diachi"/>
                        <label for="kh-sdt">SĐT:</label>
                        <input type="text" name="sdt" placeholder="SĐT..." id="kh-sdt"/>
            
                        <input type="submit" class="addpro" value="OK"/>
                    </form>
                </div>
            </div>
        </div>
            <ToastContainer/>
        </div>
    );
};

export default CartList;