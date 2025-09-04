package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;

import vn.iotstar.model.Category;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/add")
@MultipartConfig
public class CategoryAddController extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();
    final String dir = "D:/upload/category"; // thư mục lưu ảnh

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/category/add-category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        Part part = request.getPart("icon");
        String fileName = null;

        if (part != null && part.getSize() > 0) {
            fileName = System.currentTimeMillis() + "_" + part.getSubmittedFileName();
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdirs();
            }
            part.write(dir + "/" + fileName);
        }

        Category category = new Category();
        category.setName(name);
        category.setIcon(fileName);

        categoryService.insert(category);

        response.sendRedirect(request.getContextPath() + "/admin/category/list");
    }
}
