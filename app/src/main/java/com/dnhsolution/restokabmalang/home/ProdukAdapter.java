/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.dnhsolution.restokabmalang.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnhsolution.restokabmalang.R;

public class ProdukAdapter extends BaseAdapter {

  private final Context mContext;
  private final ProdukElement[] books;

  public ProdukAdapter(Context context, ProdukElement[] books) {
    this.mContext = context;
    this.books = books;
  }

  @Override
  public int getCount() {
    return books.length;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    final ProdukElement book = books[position];

    // standard implementation (should start with this)
//    if (convertView == null) {
//      final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
//      convertView = layoutInflater.inflate(R.layout.linearlayout_book, null);
//    }
//
//    final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
//    final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
//    final TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
//    final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);
//
//    imageView.setImageResource(book.getImageResource());
//    nameTextView.setText(mContext.getString(book.getName()));
//    authorTextView.setText(mContext.getString(book.getAuthor()));
//    imageViewFavorite.setImageResource(book.getIsFavorite() ? R.drawable.star_enabled : R.drawable.star_disabled);

    // view holder pattern
    if (convertView == null) {
      final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
      convertView = layoutInflater.inflate(R.layout.item_produk, null,false);

      final ImageView imageViewCoverArt = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
      final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
      final TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
      final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);

      final ViewHolder viewHolder = new ViewHolder(nameTextView, authorTextView, imageViewCoverArt, imageViewFavorite);
      convertView.setTag(viewHolder);
    }

    final ViewHolder viewHolder = (ViewHolder)convertView.getTag();
//    viewHolder.imageViewCoverArt.setImageResource(book.getImageResource());
    viewHolder.nameTextView.setText(book.getName());
    viewHolder.authorTextView.setText(book.getPrice());
    viewHolder.imageViewFavorite.setImageResource(book.isFavorite() ? R.drawable.star_enabled : R.drawable.star_disabled);

//    Picasso.get().load(book.getImageUrl()).into(viewHolder.imageViewCoverArt);

    return convertView;
  }

  private class ViewHolder {
    private final TextView nameTextView;
    private final TextView authorTextView;
    private final ImageView imageViewCoverArt;
    private final ImageView imageViewFavorite;

    ViewHolder(TextView nameTextView, TextView authorTextView, ImageView imageViewCoverArt, ImageView imageViewFavorite) {
      this.nameTextView = nameTextView;
      this.authorTextView = authorTextView;
      this.imageViewCoverArt = imageViewCoverArt;
      this.imageViewFavorite = imageViewFavorite;
    }
  }

}
