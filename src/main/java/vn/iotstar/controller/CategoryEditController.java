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

@WebServlet("/admin/category/edit")
public class CategoryEditController extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();
    final String dir = "D:/upload/category";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.get(id);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/views/admin/category/edit-category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Part part = request.getPart("icon");
        String fileName = null;

        if (part != null && part.getSize() > 0) {
            fileName = System.currentTimeMillis() + "_" + part.getSubmittedFileName();
            File file = new File(dir);
            if (!file.exists()) file.mkdirs();
            part.write(dir + "/" + fileName);
        }

        Category category = new Category();
        category.setId(id);
        category.setName(name);
        if (fileName != null) {
            category.setIcon(fileName);
        } else {
            Category old = categoryService.get(id);
            category.setIcon(old.getIcon());
        }

        categoryService.edit(category);

        response.sendRedirect(request.getContextPath() + "/admin/category/list");
    }
}
