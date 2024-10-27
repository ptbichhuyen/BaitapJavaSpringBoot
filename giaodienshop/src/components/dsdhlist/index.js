import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "./dsdh.css";

const DsdhList=() => {
    const [products, setProducts] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');
    // const [loading, setLoading] = useState(true);
    // const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8080/Hoadon/getAllHoadon')
        .then(response => {
            const sanphamData = response.data;
            setProducts(sanphamData);
            console.log(sanphamData);
        })
        .catch(error => console.error('Error fetching product:', error));
    }, []);

    return (
        <div>
            <div class="sidebar">
                <div class="logo-details">
                    <span class="logo_name">Admin</span>
                </div>
                <ul class="nav-links">
                
                    <li>
                        <a href="/sanpham">
                        <i class="bx bx-box"></i>
                        <span class="links_name">QUẢN LÝ SẢN PHẨM</span>
                        </a>
                    </li>
                    <li>
                        <a href="/Hoadon">
                        <i class="bx bx-list-ul"></i>
                        <span class="links_name">DANH SÁCH ĐẶT HÀNG</span>
                        </a>
                    </li>
                    
                    <li>
                        <a href="caidat.html">
                        <i class="bx bx-cog"></i>
                        <span class="links_name">CÀI ĐẶT</span>
                        </a>
                    </li>
                    <li class="log_out">
                        <a href="login.html">
                        <i class="bx bx-log-out"></i>
                        <span class="links_name">ĐĂNG XUẤT</span>
                        </a>
                    </li>
                </ul>
            </div>
            <section class="home-section">
                <nav>
                    <div class="sidebar-button">
                        <i class="bx bx-menu sidebarBtn"></i>
                        <span class="dashboard">DANH SÁCH ĐẶT HÀNG</span>
                    </div>
                    <div class="search-box">
                        <input type="text" placeholder="Search..." value={searchQuery} onChange={(e) => setSearchQuery(e.target.value)}/>
                        <i class="bx bx-search"></i>
                    </div>
                    <div class="profile-details">
                        <span class="admin_name">Yann&Meow</span>
                        <i class="bx bx-chevron-down"></i>
                    </div>
                </nav>
            </section>
            <div class="order">
                <div class="order-box">
                    <div class="content-box">
                        <p>Orders</p>
                        <br/>
                        <table>
                            <tr>
                                <th>Mã DH</th>
                                <th>Tên SP</th>
                                <th>Số Lượng</th>
                                <th>Tổng</th>
                                <th>Tên KH</th>
                                <th>Trạng Thái</th>
                                <th>Xử Lý</th>
                            </tr>
                            <tr class="edit">
                                <td>1</td>
                                <td>Sản phẩm A</td>
                                <td>2</td>
                                <td>1,000,000 VND</td>
                                <td>Nguyễn Văn A</td>
                                <td>Đang xử lý</td>
                                <td class="edit">
                                    <form action="xldh.html" method="get">
                                        <input type="hidden" name="madon" value="1"/>
                                        <input type="hidden" name="soluong" value="2"/>
                                        <input type="hidden" name="pdname" value="Sản phẩm A"/>
                                        <input class="ed" type="submit" name="chapnhan" value="Chấp nhận"/>
                                        <input class="de" type="submit" name="tuchoi" value="Từ Chối"/>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div> 
            <ToastContainer/>
        </div>
    );
};

export default DsdhList;