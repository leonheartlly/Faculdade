/******************************************************************************
*
* COPYRIGHT Vinícius G. Mendonça ALL RIGHTS RESERVED.
*
* This software cannot be copied, stored, distributed without  
* Vinícius G.Mendonça prior authorization.
*
* This file was made available on http://www.pontov.com.br and it is free 
* to be restributed or used under Creative Commons license 2.5 br: 
* http://creativecommons.org/licenses/by-sa/2.5/br/
*
*******************************************************************************
* Este software nao pode ser copiado, armazenado, distribuido sem autorização 
* a priori de Vinícius G. Mendonça
*
* Este arquivo foi disponibilizado no site http://www.pontov.com.br e esta 
* livre para distribuição seguindo a licença Creative Commons 2.5 br: 
* http://creativecommons.org/licenses/by-sa/2.5/br/
*
******************************************************************************/
using System;
using System.Collections;
using System.Collections.Generic;

namespace MathPhysics
{
    public class Vector2D : ICloneable, IEnumerable<double>, IEquatable<Vector2D>
    {
        #region Attributes and accessors
        /// <summary>
        /// Vector's X coordinate.
        /// </summary>
        public double X { get; set; }

        /// <summary>
        /// Vector Y coordinate.
        /// </summary>
        public double Y { get; set; }
        #endregion

        #region Constructors
        /// <summary>
        /// Builds a vector based in it's x and y components
        /// </summary>
        /// <param name="x">The value of x</param>
        /// <param name="y">The value of y</param>
        public Vector2D(double x, double y)
        {
            X = x;
            Y = y;
        }

        /// <summary>
        /// Builds a NULL vector
        /// </summary>  
        public Vector2D() : this(0, 0) {}

        /// <summary>
        /// Builds a vector based in it's x and y components
        /// </summary>
        /// <param name="xy">The values of x and y</param>
        public Vector2D(double[] xy) : this(xy[0], xy[1]) {}

        /// <summary>
        /// Builds a vector that is a copy of other vector.
        /// </summary>
        /// <param name="other">Other vector.</param>
        public Vector2D(Vector2D other) : this(other.X, other.Y) {}

        /// <summary>
        /// Builds a vector based in it's size (magnitude) and angle
        /// </summary>
        /// <param name="size">Size of the vector</param>
        /// <param name="angle">Angle</param>
        /// <returns>The newly created vector.</returns>
        public static Vector2D createBySizeAngle(float size, float angle)
        {
            return new Vector2D(Math.Cos(angle) * size, Math.Sin(angle) * size);
        }
        #endregion

        #region Properties
        public double SizeSqr
        {
            get
            {
                return X * X + Y * Y;
            }
        }

        public double Size
        {
            get
            {
                return Math.Sqrt(SizeSqr);
            }

            set
            {
                if (value == 0)
                    Set(0, 0);
                else
                {
                    double ratio = value / Size;
                    X *= ratio;
                    Y *= ratio;
                }
            }
        }

        double Angle
        {
            get
            {
                return Math.Atan2(Y, X);
            }
        }
        #endregion

        #region Methods

        public Vector2D Set(double x, double y)
        {
            X = x;
            Y = y;
            return this;
        }
        /// <summary>
        /// Changes the x and y values
        /// </summary>
        /// <param name="xy">x and y values</param>
        /// <returns>This vector</returns>
        public Vector2D Set(double[] xy)
        {
            return Set(xy[0], xy[1]);
        }

        /// <summary>
        /// Makes this vector equal to other vector.
        /// </summary>
        /// <param name="other">The vector to copy x and y values from.</param>
        /// <returns>This vector.</returns>
        public Vector2D Set(Vector2D other)
        {
            return other == this ? this : Set(other.X, other.Y);
        }

        /// <summary>
        /// Changes the size of this vector only if it's bigger than 
        /// the size parameter. 
        /// </summary>
        /// <param name="size">The maximum size of this vector</param>
        /// <returns>The truncated vector</returns>
        public Vector2D Truncate(int size)
        {
            if (SizeSqr > size*size) 
                Size = size;
            return this;
        }

        /// <summary>
        /// Rotates the vector counter-clockwise.
        /// </summary>
        /// <param name="angle">The angle to rotate, in radians.</param>
        /// <returns>The vector itself, after the rotation.</returns>
        public Vector2D Rotate(double angle)
        {
            double s = Math.Sin(angle);
            double c = Math.Cos(angle);

            double newX = X * c - Y * s;
            double newY = X * s + Y * c;

            X = newX;
            Y = newY;

            return this;
        }

        /// <summary>
        /// Normalizes this vector.
        /// </summary>
        /// <returns>The vector itself, after the normalization</returns>
        public Vector2D Normalize()
        {
            double size = Size;
            X /= size;
            Y /= size;

            return this;
        }

        /// <summary>
        /// Calculate the dot product of this vector and the given vector.
        /// Works only with normal vectors.
        /// </summary>
        /// <param name="other">Another vector.</param>
        /// <returns>The dot product.</returns>
        public double Dot(Vector2D other)
        {
            return X * other.X + Y * other.Y;
        }

        
         
        /// <summary>
        /// Returns the smallest angle between 2 vectors.
        /// The signal is used to indicate the angle rotation direction.
        /// Positive for counter-clockwise and negative for clockwise direction
         
        /// This method uses difference between two vectors.
        /// </summary>
        /// <param name="other">The vector to calculate the angle with</param>
        /// <returns>The smallest angle between two vectors.</returns>
        public double AngleBetween(Vector2D other)
        {
            double angle = other.Angle - Angle;

            if (Math.Abs(angle) < Math.PI)
                return angle;

            return angle + (angle < 0 ? 2 * Math.PI : -2 * Math.PI);
        }

        /// <summary>        
        /// Return the smallest angle between 2 vectors.
        /// The signal is used to indicate the angle rotation direction.
        /// Positive for counter-clockwise and negative for clockwise direction
        /// 
        /// This method uses the dot product.         
        /// </summary>
        /// <param name="v2">The vector to calculate the angle with</param>
        /// <returns>The smallest angle between two vectors.</returns>
        double AngleSign(Vector2D v2)
        {
            /** Must guarantee that v2 is a normalized vector */
            Vector2D v = new Vector2D(v2);
            v.Normalize();
            double dp, angPi;

            dp = Dot(v); //dot product
            if (dp >= 1.0) dp = 1.0f;
            if (dp <= -1.0) dp = -1.0f;

            angPi = Math.Acos(dp);

            //side test
            if (Y * v.X > X * v.Y)
                return -angPi;
            else
                return angPi;
        }

        public bool Equals(Vector2D other)
        {
            return this == other;
        }

        public override bool Equals(object other)
        {                       
            return GetType() != other.GetType() ? false : this == (Vector2D)other;
        }

        public override int GetHashCode()
        {
            long xb = BitConverter.DoubleToInt64Bits(X);
            long yb = BitConverter.DoubleToInt64Bits(Y);

            int result = 3;            
            result = 17 * result + (int)(xb ^ (xb >> 32));
            result = 17 * result + (int)(yb ^ (yb >> 32));
            return result;
        }

        public object Clone()
        {
            return new Vector2D(this);
        }

        /// <summary>
        /// Returns a String representation of this vector. 
        /// The string will show 4 decimal digits. If you want less or more digits, use the
        /// ToString(string) method instead.
        /// </summary>
        /// <see cref="ToString(string)"/>
        /// <returns>A string representation of this vector.</returns>
        public override string ToString()
        {
            return ToString("0.0000");
        }

        /// <summary>
        /// Returns a String representation of this vector. 
        /// 
        /// The number format follows the same rules of the String.format method. You must not
        /// provide the format enclosed in brackets or indexed.
        /// For example, for a number with 2 decimal digits, the number format whould be just "0.00". 
        /// </summary>
        /// <param name="numberFormat">The format of this number.</param>
        /// <returns>A string representation of this vector.</returns>
        public string ToString(string numberFormat)
        {
            return string.Format("X: {0:" + numberFormat + "} Y: {1:" + numberFormat + "}", X, Y);
        }
        #endregion

        #region Mathematical operators
        public static Vector2D operator +(Vector2D v1, Vector2D v2)
        {
            return new Vector2D(v1.X + v2.X, v1.Y + v2.Y);
        }

        public static Vector2D operator -(Vector2D v1, Vector2D v2)
        {
            return new Vector2D(v1.X - v2.X, v1.Y - v2.Y);
        }

        public static Vector2D operator *(Vector2D v, double scalar)
        {
            return new Vector2D(v.X * scalar, v.Y * scalar);
        }

        public static Vector2D operator *(double scalar, Vector2D v)
        {
            return new Vector2D(v.X * scalar, v.Y * scalar);
        }

        public static Vector2D operator /(Vector2D v, double scalar)
        {
            return new Vector2D(v.X / scalar, v.Y / scalar);
        }

        public static Vector2D operator -(Vector2D v)
        {
            return new Vector2D(-v.X, -v.Y);
        }
        #endregion

        #region Comparison operators
        public static bool operator ==(Vector2D v1, Vector2D v2)
        {
            return v1.X == v2.X && v1.Y == v2.Y;
        }

        public static bool operator !=(Vector2D v1, Vector2D v2)
        {
            return !(v1 == v2);
        }
        #endregion

        #region Array-like behavior
        /// <summary>
        /// Allows an array-like access to this vector.
        /// </summary>
        /// <param name="index">Use 0 for X, 1 for Y</param>
        /// <returns>The X or Y coordinate</returns>
        public double this[int index]
        {
            get
            {
                if (index == 0)
                    return X;
                if (index == 1)
                    return Y;

                throw new IndexOutOfRangeException("Index out of range: " + index);
            }

            set
            {
                if (index == 0)
                    X = value;
                else if (index == 1)
                    Y = value;
                else
                    throw new IndexOutOfRangeException("Index out of range: " + index);
            }
        }

        public IEnumerator<double> GetEnumerator()
        {
            return new VectorEnumerator(this);
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return new VectorEnumerator(this);
        }

        private class VectorEnumerator : IEnumerator<double>
        {
            private int index = 0;
            private Vector2D vector;

            public VectorEnumerator(Vector2D v)
            {
                vector = v;
            }

            public double Current
            {
                get { return vector[index]; }
            }

            public void Dispose() {}

            object IEnumerator.Current
            {
                get { return Current; }
            }

            public bool MoveNext()
            {
                index++;
                return index < 2;
            }

            public void Reset()
            {
                index = 0;
            }
        }
        #endregion
    }
}

public static class ListExtension
{
    public static IList<T> Shuffle<T>(this IList<T> me)
    {
        return me.Shuffle(new Random());
    }

    public static IList<T> Shuffle<T>(this IList<T> me, Random random)
    {
        //Embaralha a lista usando o algoritmo de Durstenfeld
        for (int i = me.Count - 1; i > 0; i--)
            me.Swap(i, random.Next(0, i));
        return me;
    }

    public static IList<T> Swap<T>(this IList<T> me, int index1, int index2)
    {
        if (index1 == index2)
            return me;

        T tmp = me[index1];
        me[index1] = me[index2];        
        me[index2] = tmp;        
        return me;
    }
}