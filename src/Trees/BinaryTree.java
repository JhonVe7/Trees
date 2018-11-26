package Trees;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
# Binary Tree Data Structure.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of Binary Trees
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class BinaryTree {
	
	public BinaryTreeNode root = null; //
	 
	/**
	 * 
	 */
	public BinaryTree() {}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void insert(BinaryTreeNode node)
	{
		// Sí no tienen raíz ese nodo va a ser la raíz
		if(isEmpty())
		{
			root = node;
		}
		else
		{
			//
			BinaryTreeNode temp = root;
			BinaryTreeNode parent = root;
			
			// Buscar el hueco
			while(temp != null)
			{
				parent = temp;
				if(node.isLessThan(temp))
					temp = temp.getLeft();
				else
					temp = temp.getRight();
			}
			
			// Insertar en el huevo
			if(node.isLessThan(parent))
				parent.setLeft(node);
			else
				parent.setRight(node);
		}
	}
	
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public BinaryTreeNode search(BinaryTreeNode nodeToSearch)
	{
		BinaryTreeNode temp = root;
		
		while(temp != null)
		{
			if(temp.isEqual(nodeToSearch))
				break;
			else
				if(nodeToSearch.isLessThan(temp))
					temp = temp.getLeft();
				else
					temp = temp.getRight();
		}
		
		return temp;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void delete(BinaryTreeNode nodeToDelete)
	{
		BinaryTreeNode temp = root;
		BinaryTreeNode parent = root;
		
		while(temp != null)
		{
			if(temp.isEqual(nodeToDelete))
				break;
			else
			{
				parent = temp;
				
				if (nodeToDelete.isLessThan(temp)) 
					temp = temp.getLeft();
				else
					temp = temp.getRight();
			}
		}
		
		if (temp != null) 
		{
			if (isLeaf(temp)) 
			{
				if (temp.isLessThan(parent))
					parent.setLeft(null);
				else
					parent.setRight(null);
			}
			else
			{
				if (oneChild(temp))
				{
					if (temp.getLeft() != null)
						if (temp.isLessThan(parent))
							parent.setLeft(temp.getLeft());
						else
							parent.setRight(temp.getLeft());
					else
						if (temp.isLessThan(parent))
							parent.setLeft(temp.getRight());
						else
							parent.setRight(temp.getRight());
				}
				else
				{
					BinaryTreeNode less = temp.getRight();
					
					while (less.getLeft() != null)
						less = less.getLeft();
					
					delete(less);
					
					less.setLeft(temp.getLeft());
					less.setRight(temp.getRight());
					
					if (temp.isLessThan(parent)) 
						parent.setLeft(less);
					else
						parent.setRight(less);
				}
			}
		}
		else
		{
			BinaryTreeNode less = temp.getRight();
				
			while (less.getLeft() != null)
				less = less.getLeft();
				
			delete(less);
				
			less.setLeft(temp.getLeft());
			less.setRight(temp.getRight());
				
			if (temp.isLessThan(parent)) 
				parent.setLeft(less);
			else
				parent.setRight(less);
		}
	}
	
	
	/**
	 * Es para saber si es una hoja
	 * @param node
	 * @return
	 */
	public boolean isLeaf(BinaryTreeNode node)
	{
		return (node.getLeft() == null && node.getRight() == null) ? true : false;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean oneChild(BinaryTreeNode node)
	{
		return (node.getLeft() != null && node.getRight() != null) ? false : true;
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void preorder(BinaryTreeNode node)
	{
		if(node != null)
		{
			System.out.print(node.toString() + " ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void postorder(BinaryTreeNode node)
	{
		if(node != null)
		{
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.print(node.toString() + " ");
		}
		
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void inorder(BinaryTreeNode node)
	{
		if(node != null)
		{
			inorder(node.getLeft());
			System.out.print (node.toString() + " ");
			inorder(node.getRight());
		}
	}

	public static void main(String[] args) 
	{
		BinaryTree bt = new BinaryTree();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			String [] numbers = br.readLine().split(",");
			
			for (int i = 0; i < numbers.length; i++) 
				bt.insert(new BinaryNodeExample(Integer.parseInt(numbers[i])));
			
			bt.preorder(bt.root);
			System.out.println();
			bt.postorder(bt.root);
			bt.delete(new BinaryNodeExample(83));
			System.out.println();
			bt.delete(new BinaryNodeExample(2));
			System.out.println();
			bt.delete(new BinaryNodeExample(69));
			System.out.println();
			bt.preorder(bt.root);
			System.out.println();
			bt.delete(new BinaryNodeExample(96));
			System.out.println();
			bt.preorder(bt.root);
			System.out.println();
			bt.inorder(bt.root);
		} 
		catch (Exception ex) {}
	}
}