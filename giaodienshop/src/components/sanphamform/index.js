import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useForm } from 'react-hook-form';
import { useNavigate, useParams, Link, useLocation } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "../sanphamlist/qlsp.css";

const SanphamForm=() => {
    const { register, handleSubmit, setValue, formState: { errors } } = useForm();
    const navigate = useNavigate();
    const { ma_sp } = useParams();
    useEffect(() => {
        if (ma_sp) {
            axios.get(`http://localhost:8080/Sanpham/getById/${ma_sp}`)
                .then(response => {
                    const product = response.data;
                    setValue('ten_sp', product.ten_sp);
                    setValue('so_luong_ton', product.so_luong_ton);
                    setValue('gia', product.gia);
                    setValue('mo_ta', product.mo_ta);
                    setValue('ma_loai', product.ma_loai);

                    
                })
                .catch(error => console.error('Error fetching customer:', error));
        }
    }, [ma_sp, setValue]);

    const onSubmit = (data) => {
        const product = {
          ...data
        };
    
        if (ma_sp) {
            axios.put(`http://localhost:8080/Sanpham/update/${ma_sp}`, product)
                .then(() => {
                    toast.success('Đã cập nhật sản phẩm thành công!');
                    setTimeout(() => navigate('/sanpham'), 2000);
                })
                .catch(error => console.error('Lỗi', error));
        } 
        else {
            axios.post('http://localhost:8080/Sanpham/create', product)
                .then(() => {
                    toast.success('Đã thêm sản phẩm thành công!');
                    setTimeout(() => navigate('/sanpham'), 2000);
                })
                .catch(error => console.error('LỖI', error));
        }
    };
    return (
        <div>
           <div className='add-pd'>
                <div className='add-pd-content'>
                    <h2>{ma_sp ? 'Edit Product' : 'New Product'}</h2>
                    <form onSubmit={handleSubmit(onSubmit)} id='add-pro'>
                        <div className="mb-3">
                            <label htmlFor="ten_sp" className="form-label">Product Name</label>
                            <input
                                type="text"
                                className="searchInput"
                                id="ten_sp"
                                {...register('ten_sp', { required: 'Name is required' })}
                            />
                            {errors.ten_sp && <span className="text-danger">{errors.ten_sp.message}</span>}
                        </div>
                
                        {/* <div className="mb-3">
                            <label htmlFor="image_path" className="form-label">Image</label>
                            <img src={previewUrl} alt='product name' className='previewUrl'/>
                            <input
                                type="file"
                                className="searchInput"
                                id="image_path"
                                {...register('image_path', { required: 'Image is required' })}
                                onChange={handleFileChange}  // Gọi hàm handleFileChange khi chọn file
                            />
                            {errors.anh_sp && <span className="text-danger">{errors.anh_sp.message}</span>}
                        </div> */}

                        <div className="mb-3">
                            <label htmlFor="so_luong_ton" className="form-label">Quantity</label>
                            <input
                                type="number"
                                className="searchInput"
                                id="so_luong_ton"
                                {...register('so_luong_ton', { required: 'Quantity is required' })}
                            />
                            {errors.so_luong_ton && <span className="text-danger">{errors.so_luong_ton.message}</span>}
                        </div>
                        <div className="mb-3">
                            <label htmlFor="gia" className="form-label">Unit Price</label>
                            <input
                                type="number"
                                className="searchInput"
                                id="gia"
                                {...register('gia', { required: 'Unit Price is required' })}
                            />
                            {errors.gia && <span className="text-danger">{errors.gia.message}</span>}
                        </div>

                        <div className="mb-3">
                            <label htmlFor="mo_ta" className="form-label">Description</label>
                            <input
                                type="text"
                                className="searchInput"
                                id="mo_ta"
                                {...register('mo_ta', { required: 'Description is required' })}
                            />
                            {errors.mo_ta && <span className="text-danger">{errors.mo_ta.message}</span>}
                        </div>

                        <div className="mb-3">
                            <label htmlFor="ma_loai" className="form-label">Category</label>
                            <input
                                type="number"
                                className="searchInput"
                                id="ma_loai"
                                {...register('ma_loai', { required: 'Category is required' })}
                            />
                            {errors.ma_loai && <span className="text-danger">{errors.ma_loai.message}</span>}
                        </div>
                
                        <div className="d-flex justify-content-end">
                            <button type="submit" className="btn btn-success me-2">Save</button>
                            <button type="button" className="btn btn-secondary" onClick={() => navigate('/products')}>Cancel</button>
                        </div>
                    </form>
                    <ToastContainer />
                </div>
            </div>
        </div>
    );
};

export default SanphamForm;