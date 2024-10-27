import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "./qlsp.css";

const SanphamList=() => {
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
    const handleEdit = (ma_sp) => {
        navigate(`/sanpham/update/${ma_sp}`);
    };
    const handleDelete = (ma_sp) => {
        if (window.confirm('Bạn có chắc chắn muốn xóa sản phẩm không ?')) {
            axios.delete(`http://localhost:8080/Sanpham/delete/${ma_sp}`)
                .then(() => {
                    setProducts(products.filter(sp => sp.ma_sp !== ma_sp));
                    toast.success('Đã xóa sản phẩm thành công!');
                })
                .catch(error => console.error('Lỗi', error));
        }
    };
    return (
        <div>
            <div className="sidebar">
                <div className="logo-details">
                    <img src="img/logo (1).png" width="30px" height="30px" alt=""/>
                    <span className="logo_name">Admin</span>
                </div>
                <ul className="nav-links">
                    <li>
                    <a href="/sanpham">
                        <i className="bx bx-box"></i>
                        <span className="links_name">QUẢN LÝ SẢN PHẨM</span>
                    </a>
                    </li>
                    <li>
                    <a href="/Hoadon">
                        <i className="bx bx-list-ul"></i>
                        <span className="links_name">DANH SÁCH ĐẶT HÀNG</span>
                    </a>
                    </li>
                    
                    <li>
                    <a href="caidat.html">
                        <i className="bx bx-cog"></i>
                        <span className="links_name">CÀI ĐẶT</span>
                    </a>
                    </li>
                    <li className="log_out">
                    <a href="login.html">
                        <i className="bx bx-log-out"></i>
                        <span className="links_name">ĐĂNG XUẤT</span>
                    </a>
                    </li>
                </ul>
            </div>
            <section className="home-section">
                <nav>
                    <div className="sidebar-button">
                        <i className="bx bx-menu sidebarBtn"></i>
                        <span className="dashboard">QUẢN LÝ SẢN PHẨM</span>
                    </div>
                    <div className="search-box">
                        <input type="text" placeholder="Search..." value={searchQuery} onChange={(e) => setSearchQuery(e.target.value)}/>
                        <i className="bx bx-search"></i>
                    </div>
                    <div className="profile-details">
                        <img src="img/logo (1).png" alt="" />
                        <span className="admin_name">Yann&Meow</span>
                        <i className="bx bx-chevron-down"></i>
                    </div>
                </nav>
            </section>
            <div className="content-box">
                <div className="sp">
                    <button id="add-pd"onClick={()=>navigate("/sanpham/create")}><span>+</span> Thêm SP</button>
                </div>
                <br/>
                <table>
                    <tr>
                        <th>Mã Sản Phẩm</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Ảnh</th>
                        <th>Số Lượng</th>
                        <th>Giá</th>
                        <th>Mô Tả</th>
                        <th>Mã Loại</th>
                        <th>Quản Lý</th>
                    </tr>
                    {filteredProducts.map(sp=>(
                        <tr className="manage" key={sp.ma_sp}>
                            <td>{sp.ma_sp}</td>
                            <td>{sp.ten_sp}</td>
                            <td><img src="img/product1.png"/></td>
                            <td>{sp.so_luong_ton}</td>
                            <td>{sp.gia} VND</td>
                            <td>{sp.mo_ta}</td>
                            <td>{sp.ma_loai}</td>
                            <td className="edit">
                                <button className='ed' onClick={()=>handleEdit(sp.ma_sp)}>Sửa</button>
                                <button className="de" onClick={()=>handleDelete(sp.ma_sp)}>Xóa</button>
                            </td>
                        </tr>
                    ))}
                </table>
            </div>
            <ToastContainer/>
        </div>
    );
};

export default SanphamList;